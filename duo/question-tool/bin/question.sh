#!/bin/bash

if [ $# -ne 3 ]; then
  echo "Wrong number of arguments." 1>&2
  exit 1
fi

echo "ST_IDX: $1"
echo "ED_IDX: $2"
echo "ITEMS_CNT: $3"

cd `dirname $0`

# 外部サイトにアクセスしてデータをDLする。
# (今後設定ファイル管理でココはON/OFFする)
python ../python/getDuoFile.py

# 問題文・解答ファイル作成スクリプト実行
python ../python/createExamFileOfEng.py $1 $2 $3

echo "Fin."
