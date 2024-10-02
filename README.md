# Spring Boot Application for Managing Users and Posts

## Overview
This application is a simple Spring Boot REST API that manages Users and Posts stored in a MongoDB database. The API includes endpoints for CRUD operations on users and posts, as well as search functionalities for posts based on titles and content.

## Prerequisites
- Java 17 or later
- Maven 3.6+ for building the project
- MongoDB running locally or on a remote server
- Docker (optional, if running MongoDB via a container)

## Configure MongoDB Connection
In the `application.properties` (or `application.yml`) file located in `src/main/resources`, configure the MongoDB connection as follows:

## Conclusion
This Spring Boot application provides REST APIs to manage users and their posts stored in MongoDB. Use the provided endpoints to create, retrieve, update, and delete users and posts, along with search functionalities for posts.