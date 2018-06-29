# Advanced Message Queueing Protocol - czesc praktyczna

Projekt przygotowany na zaliczenie przedmiotu Obliczenia rozproszone w klastrach i gridach.

## Potrzebne narzedzia
- Docker (https://www.docker.com/)
- docker-compose (https://docs.docker.com/compose/overview/)

## Uruchamianie

Wszystkie aplikacje są budowane i uruchamiane za pomocą przepisu zawartego w pliku docker-compose.yml i plikach Dockerfile.

```bash
$ docker-compose build && docker-compose up
```

## Uwagi
Kontenery dokera dzialaja bez problemu w srodowisku Linuxowym (choćby i w maszynie wirtualnej). Jest prawdopodobne, ze zadzialaja rowniez w srodowisku MacOS.

Jednak z powodu ograniczen w dzialaniu Dockera na maszynach korzystajacych z systemow Windows, mozna smialo zalozyc, ze uruchomienie przykladu sie po prostu nie uda.