(ns nodelist.core
  (:require [pallet.compute :as compute]
            [pallet.phase :as phase]
            [pallet.core :as core]
            [pallet.utils :as utils]
            [pallet.compute.node-list :as node-list])
  (:use [pallet.action.directory :only [directory]]
        [pallet.action.remote-file :only [remote-file]]
        [pallet.action.exec-script :only [exec-script]]))

;; Set this to an account name that you can use
;; preferable somewhere where you can specify an
;; "authorized_keys" for ssh

(def ACCOUNT you-probably-did-not-set-me-right?)

(defn ls [session]
  (-> session
      (exec-script
       (ls -l))))

(defn transfer [session]
  (-> session
      (directory "remote-files" :action :create)
      (remote-file "remote-files/example1.txt"
                   :local-file "local-files/example1.txt")))


(def service (compute/compute-service
              "node-list"
              :node-list [(node-list/make-node
                           "my-mac" "local-group" "127.0.0.1" :os-x)]
              :environment {:user {:username ACCOUNT :no-sudo true}}))
;; The above defaults to using .ssh/id_rsa as a private key
;; Otherwise it is also possible to specify a password using
;; :password <password> as key and value in the user map
;; Yet another version is to use :private-key-path and point
;; to a specific key
;; Anyhow, the public part of the key better be installed as
;; an authorized_key in the account we are using


(def spec (core/group-spec
           "local-group"
           :phases {:list (phase/phase-fn (ls))
                    :file (phase/phase-fn (transfer))}
           :node-spec (core/node-spec
                       :image {:os-family :os-x})))

(defn lift-all []
  (core/lift spec
             :phase [:list :file]
             :compute service))
