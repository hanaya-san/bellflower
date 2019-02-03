'''
例文リスト(duo_3-0.csv)を読み込んで、指定した範囲で問題文テキスト(.md)、解答テキスト(.md)を出力する。

・入力するcsvファイルは以下フォーマットであること。
 - id, en, ja 3つのカラムが存在する。
 - id列が連番である。

・引数
 - arg1: 出題範囲開始No.
 - arg2: 出題範囲終了No.
 - arg3: 問題数
'''

import sys
import numpy as np
import pandas as pd
from datetime import datetime
import pytz
from tabulate import tabulate

# 引数取得
args = sys.argv

# 入力エラー処理
if len(args) != 4:
    print('[ERR] Wrong number of arguments.')
    sys.exit(1)

ST_IDX = int(args[1])
EN_IDX = int(args[2])
ITEMS_CNT = int(args[3])

# 一旦ここで各種パスを定義しておきます。
INPUT_CSV_DIR = '../data/output/raw/'
INPUT_TMP_DIR = '../data/input/templete/'
OUTPUT_DIR = '../data/output/md/'
IN_CSV_FILE_NAME = 'duo_3-0'
IN_TMP_FILE_NAME = 'mdFileTemplete'

# 現在時刻(日本時間)を取得
dt_now_ja = datetime.now(pytz.timezone('Asia/Tokyo')).strftime('%Y/%m/%d')

# 例文リストをロードしてデータフレームに格納
sentence_df = pd.read_csv('%s%s.csv'%(INPUT_CSV_DIR, IN_CSV_FILE_NAME))

# 読み込んだデータフレームのid最大値を取得
id_range_max = sentence_df['id'][-1:].values[0]
print(id_range_max)
# 入力エラー処理
if (ST_IDX > id_range_max) | (EN_IDX > id_range_max) | (ITEMS_CNT > id_range_max):
  print('[ERR] Set a value larger than raw_file_count')
  sys.exit(1)

if ST_IDX > EN_IDX:
  print('[ERR] Set the value of ST_IDX larger than FN_IDX')
  sys.exit(1)
  
if (EN_IDX-ST_IDX) < ITEMS_CNT-1:
  print('[ERR] ITEMS_CNT must specify the range of ST_IDX and FN_IDX')
  sys.exit(1)

# 出力ファイルテンプレートを読み込み
with open('%s%s.txt'%(INPUT_TMP_DIR, IN_TMP_FILE_NAME), mode='r', encoding='utf-8') as f:
  raw = f.read()

# 解答データフレームを作成
answer_df = pd.DataFrame()
answer_df = sentence_df.query('%d <= id <= %d'%(ST_IDX, EN_IDX))
answer_df = answer_df.sample(frac=1)[0:ITEMS_CNT].sort_index(ascending=True).reset_index(drop=True)
answer_df = answer_df.loc[:,['id', 'ja', 'en']]
answer_df = answer_df.rename(columns={'id':'No', 'ja': '問題', 'en': '回答'})

# 問題データフレームを作成
question_df = pd.DataFrame()
question_df['No'] = answer_df['No']
question_df['問題'] = answer_df['問題']
question_df['回答'] = ' '

# テキスト(markdown記法)を成形
tmp_txt = raw
tmp_txt = tmp_txt.replace('__MASTER_FILE_NAME__', 'duo')
tmp_txt = tmp_txt.replace('__RUN_DATE__', dt_now_ja)
tmp_txt = tmp_txt.replace('__ST_IDX__', str(ST_IDX))
tmp_txt = tmp_txt.replace('__EN_IDX__', str(EN_IDX))
tmp_txt = tmp_txt.replace('__ITM_CNT__', str(ITEMS_CNT))
q_txt = tmp_txt.replace('__EXAM__', tabulate(question_df, tablefmt='markdown', headers='keys', showindex=False))
a_txt = tmp_txt.replace('__EXAM__', tabulate(answer_df, tablefmt='markdown', headers='keys', showindex=False))

with open('%squestion.md'%(OUTPUT_DIR), mode='w', encoding='utf-8') as f:
  f.write(q_txt)
print('[INF] Output %squestion.md'%(OUTPUT_DIR))

with open('%sanswer.md'%(OUTPUT_DIR), mode='w', encoding='utf-8') as f:
  f.write(a_txt)
print('[INF] Output %sanswer.md'%(OUTPUT_DIR))

sys.exit(0)
