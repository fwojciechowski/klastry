FROM node:alpine

RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh

WORKDIR /usr/src/app

COPY src .

RUN npm install bower -g && npm install
RUN bower install --allow-root

CMD [ "node", "main.js" ]