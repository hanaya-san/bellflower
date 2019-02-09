# question-tool

## 概要

- 小テストの自動作成ツール
    - 問題出題範囲,問題数を指定するとランダムで問題文とその答えが出力される
    - 任意のマスターデータを読み込み、そのマスターデータから問題を出力する

- 想定する使用例
    - 第1回小テストはNo1〜10のうちから10問(全て出題)
    - 第2回小テストはNo11〜20のうちから10問(全て出題)
    - 第3回小テストはNo21〜30のうちから10問(全て出題)
    - 第4回小テストはNo1〜30のうちからランダムで10問

---

# Dependency

- TODO: この項目は必要に応じて編集してくれ(いらなかったら項目ごと削除してくれ)
- にいさんにおまかせ
- 一般的に..
    - 使用言語とバージョン、必要なライブラリとそのバージョンを書く
    - Pythonならrequirements.txtを用意するのも良い
    - とのこと

---

# Setup

- 必要なライブラリをインストールする

```
pip install Requests
pip install beautifulsoup4
```

- 任意でzshrcなどにエイリアスを追加

```
alias question='bash ~/hanaya-san/bellflower/duo/question-tool/bin/question.sh'
```

---

# Usage

## 問題出力機能

例文リスト(duo_3-0.csv)を読み込んで、指定した範囲で問題文テキスト(.md)、解答テキスト(.md)を出力する。

・入力するcsvファイルは以下フォーマットであること。
 - id, en, ja 3つのカラムが存在する。
 - id列が連番である。

・引数
 - arg1: 出題範囲開始No.
 - arg2: 出題範囲終了No.
 - arg3: 問題数

```
# コマンド例(No1〜20のうちから10問出題)
./bin/question.sh 1 20 10
# 以下のディレクトリに問題とその回答が出力される
./data/output/md/[answer|question].md
```

---

# Authors

- [rothr4](https://github.com/rothr4)

---

# References

- [Duo3\.0のテキスト加工 \- b2fireb4beatのブログ](http://b2fireb4beat.hatenablog.com/entry/2017/07/25/163740)

