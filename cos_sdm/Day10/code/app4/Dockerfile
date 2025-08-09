# set the base image
FROM node:lts-alpine3.20

# set the working directory to copy the server code
WORKDIR /src

# copy the files from current directory to the working directory of image
COPY . .

# install dependencies
RUN npm install express cors

# expose port 4000
EXPOSE 4000

# start the server application
CMD node server.js

