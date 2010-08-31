(ns swing.records
  (:use [swank.swank :as swank]))

(defprotocol Indexed,
  (at [this, i] "return el at ith pos"),
  (atwithdef [this, i, d] "...."))

(defprotocol TopScored,
  (topscore [this] "return topscore"))

(defrecord Highscores [scores],
  Indexed,
   (at [this i], 
       (nth scores i))
   (atwithdef [this i d],
       (nth scores i d)),

  TopScored,
   (topscore [this],
	     (at this 0)))

