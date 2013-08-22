(defproject ffc "0.1.0-SNAPSHOT"
  :description "FlyFishing Companion: River Schedule"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
 				        [org.clojure/java.jdbc "0.2.3"]
                [postgresql "9.1-901.jdbc4"]
                [ring/ring-jetty-adapter "1.1.6"]
                [compojure "1.1.3"]
                [hiccup "1.0.2"]
                [clj-http "0.7.6"]
                [org.clojure/data.xml "0.0.7"]]
  :main ffc.core)
