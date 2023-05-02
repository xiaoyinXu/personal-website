FROM node:19.7-alpine
COPY ./frontend/ /app
WORKDIR /app
RUN rm -rf node_modules
RUN npm install
RUN npm run build

FROM nginx:1.23.3
COPY --from=0 /app/dist /dist

ENTRYPOINT ["/docker-entrypoint.sh"]

EXPOSE 80

STOPSIGNAL SIGQUIT

CMD ["nginx", "-g", "daemon off;"]
