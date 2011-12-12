(defproject simple-nodelist "1.0.0-SNAPSHOT"
  :description "Example project for working with nodelist"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [org.cloudhoist/pallet "0.6.5-SNAPSHOT"]
                 [org.jclouds.driver/jclouds-log4j "1.1.1"]
                 [log4j/log4j "1.2.14"]]
  :dev-dependencies [[swank-clojure "1.3.2"]]
  :repositories {"sonatype"
                 "https://oss.sonatype.org/content/repositories/releases"
                 "sonatype-snapshots"
                 "http://oss.sonatype.org/content/repositories/snapshots"}
  :main nodelist.main)
