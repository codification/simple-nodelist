(ns nodelist.main
  (:use [nodelist.core :only [lift-all]]))

(defn -main [& args]
  (lift-all))
