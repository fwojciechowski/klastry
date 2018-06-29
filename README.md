# Advanced Message Queueing Protocol - czesc praktyczna

Projekt przygotowany na zaliczenie przedmiotu Obliczenia rozproszone w klastrach i gridach.

## Potrzebne narzedzia
- Docker (https://www.docker.com/)
- docker-compose (https://docs.docker.com/compose/overview/)

## Uruchamianie

Wszystkie aplikacje są budowane i uruchamiane za pomocą przepisu zawartego w pliku docker-compose.yml.

```bash
$ docker-compose build && docker-compose up
```

## Uwagi
Kontenery dokera dzialaja bez problemu w srodowisku Linuxowym. Jest prawdopodobne, ze zadzialaja rowniez w srodowisku MacOS.

Jednak z powodu ograniczen w dzialaniu Dockera na maszynach korzystajacych z systemow Windows, mozna smialo zalozyc, ze chocby bez wirtualnej maszyny Linuxa, uruchomienie przykladu sie po prostu nie uda.