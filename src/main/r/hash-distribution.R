files <- c("/tmp/hashes-words-mm3.csv",
           "/tmp/hashes-words-fnv.csv",
           "/tmp/hashes-words-multi-fnv-0.csv",
           "/tmp/hashes-words-multi-fnv-1.csv",
           "/tmp/hashes-words-multi-fnv-5.csv",
           "/tmp/hashes-words-multi-fnv-10.csv")

#files <- c("/tmp/hashes-words-mm3.csv")

read_data <- function(filename) {
  return(c(filename, read.csv(filename)))
}

get_distribution <- function(csv) {
  filename <- csv[1]
  min <- min(csv$hash) + 1
  max <- max(csv$hash)
  hash2 <- (csv$hash - min) / (max - min)
  uhash2 <- unique(hash2)
  return(c(filename,uhash2))
}

dists <- lapply(lapply(files, read_data), get_distribution)

#par(mfrow = c(3, 2))
for (csv in csvs) {
  filename <- csv[1]
  #plot(csv$hash, main = filename, xaxt = "l")
  #plot(density(csv$hash), main = filename, xaxt = "l")  
  min <- min(csv$hash) + 1
  max <- max(csv$hash)
  hash2 <- (csv$hash - min) / (max - min)
  uhash2 <- unique(hash2)
  return uhash2
  #df <- data.frame(uhash2)
  #m <- ggplot(df, aes(x=uhash2))
  #m + geom_histogram(aes(fill = ..count.. ))
  
  #plot(density(uhash2), main = filename, xaxt = "l")
  #pv <- ks.test(uhash2, "punif")$p.value
  #print(c(filename, pv))
}


