= vertx-kotlin-react-bolerplate

== Requirements

* Java 8
* Node.js with npm

== Build

```
$ git clone https://github.com/zoetrope/vertx-kotlin-react-boilerplate.git
$ cd vertx-kotlin-react-boilerplate
$ npm i
$ ./node_modules/.bin/webpack
$ ./gradlew shadowJar
```

## Run

```
$ java -jar build/libs/vertx-kotlin-react-boilerplate-1.0-SNAPSHOT-fat.jar
```

## Development

```
$ ./node_modules/.bin/webpack --watch
$ ./gradlew run
```
