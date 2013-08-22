(ns ffc.riverdata
  (:use [clj-http.client :as client])
  (:use [clojure.data.xml :as xml]) )
  
  (def urls {"caney" "http://www.tva.gov/lakes/xml/CNH_F.xml",
        "elk" "http://www.tva.gov/lakes/xml/TFH_F.xml"})
  
  (defn raw [x] (:body (client/get (urls x))))
  
  
  (defn get-tag-content [tag-name row] 
    (for  [x row
            :when (= (keyword tag-name) (:tag x))]
            (first (:content x))))
  
  
  (defn process-row [row]
    (let [date (apply str (get-tag-content "RELEASEDATE" row))
          timeperiod (apply str (get-tag-content "TIMEPERIOD" row))
          generators (apply str (get-tag-content "GENERATORS" row))]
          {:date date :timeperiod timeperiod :generators generators}))
          ;(apply str date "," timeperiod "," generators)))
  
  
  
  (defn current [x]
    (def rows (for [x (xml-seq 
                  (parse-str (:body (client/get (urls x)))))
                     :when (= :ROW (:tag x))]
            (process-row (:content x))))
    (clojure.string/join "<br/>" rows))
    
  
    
  
  
  