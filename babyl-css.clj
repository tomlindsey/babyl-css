(with-open [o (clojure.java.io/writer "/Users/me/scratch/foo.css")]
  (doseq [x (range 1 42)]
    (let [w (* 60 x)]
      (doseq [c (range 1 7)]
        (.write o (str ".b"w "_c" c " { box-sizing:border-box; width:calc(" w "px / " c"); }\n"))
        (if (> c 2)
          (.write o (str ".b"w "_c" c "x { box-sizing:border-box; width:calc("w "px - (" w "px / " c ")); }\n")))))
      (.write o "\n")))
