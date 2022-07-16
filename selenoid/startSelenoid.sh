#!/bin/bash
docker pull selenoid/vnc:firefox_45.0
docker pull selenoid/vnc:chrome_76.0
docker pull selenoid/vnc:chrome_79.0
docker-compose down -v
docker-compose up -d
docker-compose logs -f