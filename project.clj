(defproject study-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.datomic/datomic-free "0.9.5544"]
                 [io.rkn/conformity "0.5.1"]
                 [com.taoensso/timbre "4.10.0"]
                 [mount "0.1.9"]
                 [midje "1.9.9"]]
  :plugins [[lein-midje "3.2.1"]]
  :profiles {:dev {:source-paths ["src" "dev"]}}
  :repl-options {:init-ns user})
