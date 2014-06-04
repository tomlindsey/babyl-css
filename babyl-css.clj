;;;;
;;;; junk code; not idiomatic clojure
;;;; hopefully non-lisp types can follow this simple script
;;;;
;;;; example output
;;;; .b960_c6 { box-sizing:border-box; width:calc(960px / 6); }
;;;; .b960_c6x { box-sizing:border-box; width:calc(960px - (960px / 6)); }
;;;;
;;;; sure, I could have calculated the widths, but, again, I wanted things
;;;; CSS to be obvious.

(with-open [fileWriter (clojure.java.io/writer "/Users/me/scratch/foo.css")]
  (doseq [n (range 1 42)]
    (let [width (* 60 n)]
      (doseq [column (range 1 7)]
        (.write fileWriter (str ".b" width "_c" column " { box-sizing:border-box; width:calc(" width "px / " column "); }\n"))
        (if (> column 2)
          (.write fileWriter (str ".b" width "_c" column "x { box-sizing:border-box; width:calc(" width "px - (" width "px / " column ")); }\n")))))
      (.write fileWriter "\n")))
