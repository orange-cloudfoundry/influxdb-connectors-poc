influxdb-connectors-poc
===================

Show how to use the influxDB connector with Cloud Foundry in spring boot. You can find this connector here [https://github.com/Orange-OpenSource/spring-cloud-influxdb-connectors](https://github.com/Orange-OpenSource/spring-cloud-influxdb-connectors).

What's inside ?
---------------

You will found a small web app with a scheduled task to push some data into an influxDB database.
 

Deploy It !
-----------

**In all cases:**

1. Clone this repo: `git clone https://github.com/orange-cloudfoundry/influxdb-connectors-poc.git`
2. Go inside the new created folder in command line: `cd influxdb-connectors-poc`
3. Build the app with maven: `mvn clean install`

### On Cloud Foundry

1. Create an influxDB service
Since no influxDB service offering seems to be available in any marketplace, you can use an influxDB service by creating the following user provided service.
```shell
$cf cups influxdb-service -p '{"dbname": "<DB_NAME>", "hostname": "<HOSTNAME>", "password": "<PASSWORD>", "port": "<PORT>", "uri": "<URI>", "username": "<USERNAME>"}'
```
2. In command line do a `cf push`
3. After the app has been pushed bind your new created service to your app (e.g: `cf bs poc-influxdb influxdb-service`)
4. Restage your app: `cf restage poc-influxdb`

### On heroku

Not supported

### Locally

Not Supported