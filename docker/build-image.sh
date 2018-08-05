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



cd ..
mvn clean package -Dmaven.test.skip=true docker:build