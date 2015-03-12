module Bassbull where

import qualified Data.ByteString.Lazy as BL
import qualified Data.Foldable as F
import Data.Csv.Streaming

type BaseballStats = (BL.ByteString, Int, BL.ByteString, Int)

baseballStats :: BL.ByteString -> Records BaseballStats
baseballStats = decode NoHeader

fourth :: (a, b, c, d) -> d
fourth (_, _, _, d) = d

summer :: (a, b, c, Int) -> Int -> Int
summer = (+) . fourth

-- FilePath is just an alias for String
getAtBatsSum :: FilePath -> IO Int
getAtBatsSum battingCsv = do
  csvData <- BL.readFile battingCsv
  return $ F.foldr summer 0 (baseballStats csvData)