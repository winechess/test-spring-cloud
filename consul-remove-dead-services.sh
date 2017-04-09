#!/bin/bash
for i in $(http :8500/v1/health/state/critical | jq .[].ServiceID | tr -d '"');
do
    http PUT :8500/v1/agent/service/deregister/${i};
done
