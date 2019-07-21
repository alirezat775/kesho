# kesho

--------------------------------------------------------------------
Useful library for push and pull from kesho

Options
- push boolean, string, float, int, long, anyObject 
- pull boolean, string, float, int, long, anyObject
- cache with timeToLife
- clear all cache
- remove specific key
- check has specific key
- check valid specific key
- encrypt data with secret key

### Issue
- [bug report](.github/ISSUE_TEMPLATE/bug_report.md)
- [feature request](.github/ISSUE_TEMPLATE/feature_request.md)


### Usage

add to root build.gradle
```groovy

    maven { url "https://jitpack.io" }

```

add to module build.gradle
```groovy

    implementation 'com.github.alirezat775:kesho:{latest-version}'

```

- [changelog](CHANGELOG)

### contribution guidelines

please commit in development branch and send a pull request to merge development branch.
explain better in a commit message, don't remove class author and add your data in a header of class