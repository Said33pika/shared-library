#!/usr/bin/env groovy

import org.apache.commons.lang.StringUtils

def call(String filter_string, int occurrence) {
    def logs = currentBuild.rawBuild.getLog(10000).join('\n')
    int count = StringUtils.countMatches(logs, filter_string);
    println(count)
    println(occurrence)
    if (count > occurrence - 1) {
        currentBuild.result = 'UNSTABLE'
    }
    else{
        println (currentBuild.currentResult)
    }

}
