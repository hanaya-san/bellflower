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
- 環境
    - Python 3.6.5 :: Anaconda, Inc.
    - anaconda Command line client (version 1.6.14)

---

# Setup

## 必要なライブラリをインストールする
```
# conf/requirements.txt : 一括インストール用設定ファイル
$ pip install -r ${requirements.txtのパス}
```

## モジュールのバージョン一覧
    - numpy==1.14.3
    - pandas==0.23.0
    - requests==2.18.4
    - pytz==2018.4
    - tabulate==0.8.3
    - beautifulsoup4==4.6.0

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

[Duo 3.0 復習用まとめ Section 1-45](https://quizlet.com/5792378/duo-30-%E5%BE%A9%E7%BF%92%E7%94%A8%E3%81%BE%E3%81%A8%E3%82%81-section-1-45-flash-cards/)

