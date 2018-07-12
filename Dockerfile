FROM airhacks/glassfish
COPY ./target/hardcoredistro.war ${DEPLOYMENT_DIR}
