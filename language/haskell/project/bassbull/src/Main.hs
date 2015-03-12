module Main where

import Bassbull

main :: IO ()
main = do
  summed <- getAtBatsSum "batting.csv"
  putStrLn $ "Total atBats was: " ++ (show summed)