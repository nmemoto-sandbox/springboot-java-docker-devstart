# Devstart for Spring Boot with Java and Docker
Spring Boot を Java と Docker で開発するためのテンプレ案

## やったこと
* データベースマイグレーション環境
    * Flyway 導入
* Docker Compose での開発環境
    * docker-compose.yml でアプリとデータベースのコンテナを用意
* 本番等でのコンテナ利用環境
    * jib の導入
* 動作確認のためのサンプルアプリを同梱
    * Todo の CRUD の REST API
        * TodoController.javaでエンドポイント, Todo.javaで項目を確認できる

## やりたいこと
* Auto Restart
    * `./gradlew bootRun` は `build/classes/java/main/`以下の変更を監視しているが、IDE(IntelliJ)上だと`out`以下となるため、変更を検知できず、Auto Restartはできていない
    * 現状は gradle の classes タスクを実行している
