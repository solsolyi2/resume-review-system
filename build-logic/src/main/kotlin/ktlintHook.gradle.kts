tasks.named("prepareKotlinBuildScriptModel") {
  dependsOn("addKtlintFormatGitPreCommitHook")
}
