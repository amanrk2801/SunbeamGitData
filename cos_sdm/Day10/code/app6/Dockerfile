# set the base image
FROM mysql

# set the mysql root user's password
ENV MYSQL_ROOT_PASSWORD=root

# set the database name
ENV MYSQL_DATABASE=ecommerce_db

# copy the schema to the entrypoint location of mysql image
COPY . /docker-entrypoint-initdb.d/

# expose the mysql port
EXPOSE 3306