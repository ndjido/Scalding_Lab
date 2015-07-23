name := "WordCount"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++=Seq(
  "com.twitter" %% "scalding-args"  % "0.14.0",
  "com.twitter" %% "scalding-core"  % "0.14.0",
  "org.apache.hadoop" % "hadoop-core" % "1.2.1"
)

