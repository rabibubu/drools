#!/bin/bash

touch src/test/java/com/bnsf/rule/test/ApprovalTest.java
./gradlew -Dtest.single=ApprovalTest test