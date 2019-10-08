(ns study-test.database
  (:require [mount.core :as mount]
            [datomic.api :as d]
            [io.rkn.conformity :as c]
            [taoensso.timbre :as log]))

(defn start-datomic!
  [{:keys [env uri] :as cfg}]
  (log/info (format "creating the %s database" env))
  (d/create-database uri)
  (let [conn (d/connect uri)]
    (doseq [schema ["schemas/credit.edn"]]
      (log/info (format "schemas being created in %s database" env))
      (let [norms (c/read-resource schema)]
        (c/ensure-conforms conn norms)))))

(mount/defstate server
  :start (start-datomic! {:env "PROD" :uri "datomic:mem://credit"})
  :stop {:connection nil})
