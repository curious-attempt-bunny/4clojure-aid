; Given a function f and a sequence s, write a function which returns a map.  The keys should be the values of f applied to each item in s.  The value at each key should be a vector of corresponding items in the order they appear in s.
; http://www.4clojure.com/problem/63
; Don't use: group-by

; (= (__ #(> % 5) #{1 3 6 8}) {false [1 3], true [6 8]})
; (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])    {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
; (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])    {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

(fn [f coll]
	(reduce
		(fn [result elem]
			(let [key  (f elem)
					  vals (get result key [])]
				(assoc result key (conj vals elem))))
		{}
		coll))