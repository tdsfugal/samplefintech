# scala-howtographql

This project is a learning exercise in using graphql with scala. It has a back-end that serves representative fintech data to a front-end react app via a graphql link.

## USE

Open two terminals. In one, navigate into client and run "yarn start". In the other, navigate into "server" and run "sbt run".

The graphql endpoint can be observed at localhost:8080. It does really nothing right now except relay the three hardcoded values from the scala/graphql tutorial.

The React app is at localhost:3000. It runs the query internally and puts the results on the console. No tables, graphs, or charts yet.
