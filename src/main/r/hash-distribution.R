files <- c("/tmp/hashes-words-mm3.csv",
           "/tmp/hashes-words-multi-mm3-0.csv",
           "/tmp/hashes-words-multi-mm3-1.csv",
           "/tmp/hashes-words-multi-mm3-5.csv",
           "/tmp/hashes-words-multi-mm3-10.csv")

csvs <- lapply(files, function(x) c(x, read.csv(x)))

par(mfrow = c(3, 2)) 
for (csv in csvs) {
  data <- csv[0]
  filename <- csv[1]
  plot(density(csv$hash), main = filename)
}

