'''
Quizletの以下頁にある例文(英-和)をスクレイピングして、csvとtxtを出力する
https://quizlet.com/39180682/duo-30-%E5%BE%A9%E7%BF%92%E7%94%A8%E5%85%A8%E4%BE%8B%E6%96%87-%E8%8B%B1%E5%92%8C-flash-cards/
'''

import os
import sys
import numpy as np
import pandas as pd
import requests
from bs4 import BeautifulSoup

# ===== Def =====
# 出力情報を定義(適宜変更お願いします)
OUTPUT_DIR = '../data/output/raw/'
FILE_NAME = 'duo_3-0'

# アクセスするURLを定義
QUIZLET_URL = "https://quizlet.com/39180682/duo-30-%E5%BE%A9%E7%BF%92%E7%94%A8%E5%85%A8%E4%BE%8B%E6%96%87-%E8%8B%B1%E5%92%8C-flash-cards/"

print('[INF] GET Request: %s'%(QUIZLET_URL))
# 指定URLにGET
html = requests.get(QUIZLET_URL)
print('[INF] Res: %s'%(html))

# データフレームを初期化
sentence_df = pd.DataFrame()

# BeautifulSoupオブジェクトを生成
soup = BeautifulSoup(html.text, 'html.parser')

# htmlから英文と和文の部分を抽出してデータフレームに格納する
navi_str_en_list = soup.find_all("span", class_="TermText notranslate lang-en")
navi_str_ja_list = soup.find_all("span", class_="TermText notranslate lang-ja")
sentence_df['id'] = range(1, len(navi_str_en_list)+1)
sentence_df['en'] = [str(navi_str_en_list[i].string) for i in range(len(navi_str_en_list))]
sentence_df['ja'] = [str(navi_str_ja_list[i].string) for i in range(len(navi_str_ja_list))]

if os.path.isfile('%s%s.txt'%(OUTPUT_DIR, FILE_NAME)):
    os.remove('%s%s.txt'%(OUTPUT_DIR, FILE_NAME))
    #print('[INF] Delete: %s%s.txt'%(OUTPUT_DIR, FILE_NAME))

for i in range(len(sentence_df.index)):
    with open('%s%s.txt'%(OUTPUT_DIR, FILE_NAME), mode='a', encoding='utf-8') as f:
        f.write('\n%d\n%s\n%s\n'%(i+1, sentence_df['en'][i], sentence_df['ja'][i]))
print('[INF] Output: %s%s.txt'%(OUTPUT_DIR, FILE_NAME))

sentence_df.to_csv('%s%s.csv'%(OUTPUT_DIR, FILE_NAME), index=False)
print('[INF] Output: %s%s.csv'%(OUTPUT_DIR, FILE_NAME))

sys.exit(0)
