#!/bin/bash
set -eux

declare -r HOST="web:8080/actuator/health"

wait-for-url() {
    echo "executin $1"
    timeout -s TERM 150 bash -c \
    'while [[ "$(curl -s -o /dev/null -L -w ''%{http_code}'' ${0})" != "200" ]];\
    do echo "Waiting for ${0}" && sleep 10;\
    done' ${1}
    echo "OK!"
    curl -I $1
}
wait-for-url http://${HOST}
