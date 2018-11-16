logLevel := Level.Warn

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.2")
addSbtPlugin("io.get-coursier"  % "sbt-coursier"        % "1.0.3")
addSbtPlugin("ch.epfl.scala"    % "sbt-bloop"           % "1.0.0")
addSbtPlugin("com.thesamet"     % "sbt-protoc"          % "0.99.15")

libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin" % "0.6.7"
