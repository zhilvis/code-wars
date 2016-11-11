(ns boot.user)

(set-env!
  :dependencies '[
                  [org.clojure/clojure  "1.8.0"]

                  [http-kit  "2.1.17"]
                  [org.clojure/data.json  "0.2.6"]
                  [com.cemerick/url  "0.1.1"]
                  [mount "0.1.10"]
                  [compojure  "1.4.0"]
                  [ring/ring-defaults  "0.2.1"]
                  [pandeiro/boot-http  "0.7.3"]
                  [adzerk/boot-cljs          "1.7.228-1"]
                  [adzerk/boot-reload        "0.4.11"]
                  [adzerk/boot-cljs-repl     "0.1.9"]
                  [hoplon/boot-hoplon        "0.2.2"]

                  [hoplon/hoplon             "6.0.0-alpha16"]
                  [hoplon/castra  "3.0.0-alpha4"]
                  [org.clojure/clojurescript  "1.9.93"]]

  :source-paths #{"src"}
  :resource-paths #{"resources"})

(require
  '[adzerk.boot-cljs         :refer  [cljs]]
  '[adzerk.boot-cljs-repl    :refer  [cljs-repl start-repl]]
  '[adzerk.boot-reload       :refer  [reload]]
  '[hoplon.boot-hoplon       :refer  [hoplon prerender]]
  '[pandeiro.boot-http :refer  [serve]])


(deftask dev []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs)
    (serve
      :port 8000
      :reload true
      :handler 'inventi.app/handler
      :init 'inventi.app/start!)
    (repl :server true)))

