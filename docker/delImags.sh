#!/usr/bin/env bash
echo '============================================================='
echo '$                                                           $'
echo '$                      wangxu                               $'
echo '$                                                           $'
echo '$                                                           $'
echo '$  email:    wangxud1991@gmail.com                          $'
echo '$  homePage: http://www.wxvoid.com/                         $'
echo '$  Github:   https://github.com/wangxud                     $'
echo '$                                                           $'
echo '============================================================='
echo '.'
#
docker rmi  search-movie_redis
docker rmi  search-movie_nginx
docker rmi  wangxucode1991/search-movie
docker rmi  hub.c.163.com/library/centos
docker rmi  java
cd ..
docker images