docker run --name fintech-redis \
             -p 6379:6379 \
             --network docker_fintech \
             -d redis:latest
