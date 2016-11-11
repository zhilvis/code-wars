(ns inventi.app
  (:require
    [ring.middleware.defaults :as mid]
    [castra.middleware :as castra]
    [compojure.route :as route]
    [compojure.core :as cmpj :refer  [GET POST context defroutes]]))

(defroutes routes
  (route/resources  "/"  {:root  ""})
  (route/resources  "/"))

(def handler
  (->
    #'routes
    (castra/wrap-castra 'inventi.backend)
    (mid/wrap-defaults  (assoc mid/api-defaults :session true))))

(defn start! [])
