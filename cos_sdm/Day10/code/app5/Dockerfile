FROM node:lts-alpine3.20
WORKDIR /src
COPY . . 
RUN npm install
EXPOSE 5173
CMD npm run dev --host 0.0.0.0
