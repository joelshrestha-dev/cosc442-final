# Local test and mutation results

Verified November 4, 2026.

Run from the JoshHack project directory in Windows PowerShell:

```powershell
.\mvnw.cmd clean compile test
.\mvnw.cmd -B test org.pitest:pitest-maven:mutationCoverage
```

On macOS/Linux, replace `.\mvnw.cmd` with `./mvnw`.

Both commands completed with BUILD SUCCESS. All 6 existing tests passed,
with 0 failures, 0 errors, and 0 skipped tests, both before and after the
PIT configuration change.

PIT uses the same versions as CoffeeMaker: pitest-maven 1.20.2 and
pitest-junit5-plugin 1.2.3. Only `game.*` production classes are targeted;
the UI package is outside that target. No mutationThreshold is configured.

Mutation results:

| Result | Count |
| --- | ---: |
| Generated mutations | 1,028 |
| Killed | 16 |
| Survived | 3 |
| No coverage | 1,009 |
| Mutation coverage (rounded by PIT) | 2% |
| Test strength | 84% |
| Line coverage for mutated classes | 31 / 1,253 (2%) |

The HTML report is generated at `target/pit-reports/index.html`.
The current tests cover only a small part of the game package; improving
the test suite is outside this task. No production code or tests were changed.

Maven also reports existing warnings about the project-local asciiPanel.jar
system dependency and compiling with source/target 17 without a system
modules path. These did not prevent either build from succeeding.
