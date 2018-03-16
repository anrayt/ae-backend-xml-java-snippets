Application for locates some element on web page similar to some input element.

Build executable jar:
 - gradle clean
 - gradle executableJar

 Jar will be here : ./build/libs/ae-backend-xml-java-snippets-all-0.0.1.jar

 This jar can be run with 3 arguments :
  1. original file path (./[some path])
  2. diff file path (./[some path])
  3. element's id ([some id])

  Example :
  java -cp ae-backend-xml-java-snippets-all-0.0.1.jar com.agileengine.antonratiy.EntryPoint ./sample-0-origin.html ./sample-4-the-mash.html make-everything-ok-button

 also possible to run with such command
 java -jar ae-backend-xml-java-snippets-all-0.0.1.jar ./sample-0-origin.html ./sample-4-the-mash.html make-everything-ok-button

 Output will contain info about found element:
 - css selector
 - html markup
 - description why it was chosen
 - number of params why it was chosen (identity level)

 Output for all runs provided in results.txt