FROM node:19.7-alpine
COPY ./frontend/vue-project/ /app
WORKDIR /app
RUN npm run build

FROM node:19.7-alpine
COPY --from=0 /app/dist /dist

ENTRYPOINT ["/docker-entrypoint.sh"]

EXPOSE 80

STOPSIGNAL SIGQUIT

CMD ["nginx", "-g", "daemon off;"]
