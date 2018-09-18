# Realm of the Mad Tom
A Java-based MUD. What more do you want?

## Project information
For a detailed understanding of the project's objectives and basic gameplay, please consult the [spec writeup](SPEC.md).

## Compiling, running, and deployment
### Running in Eclipse
1. Import the project into Eclipse using the Project Import Wizard.
2. Click the "Run" button to compile and run.

#### Adding to your build path
##### IntelliJ:
1. Right-click on the library JAR file in `libraries` and select 'Open Library Settings...'.
2. In the Export pane, check the box next to the library JAR file.

##### Eclipse:
1. Right-click on the library JAR file in `libraries` and select 'Build Path > Add to Build Path'.

#### Exporting app with libraries
##### IntelliJ
1. Go to 'File > Project Structure > Project Settings > Artifacts'.
2. Click the Plus button, followed by 'JAR > From modules and dependencies'.
3. Follow the prompts.
4. Add the step to your Run/Debug configuration.

##### Eclipse
1. Go to 'File > Export' and select 'Java > Runnable JAR file'.
2. Ensure that the option 'Package required libraries into generated JAR' is selected. Follow all other prompts.

## Commit conduct
- Branches must be merged via a pull request before deletion.
> From Stack Overflow:
> Avoid long descriptive names
>
> Long branch names can be very helpful when you are looking at a list of branches. But it can get in the way when looking at decorated one-line logs as the branch names can eat up most of the single line and abbreviate the visible part of the log.
>
> On the other hand long branch names can be more helpful in "merge commits" if you do not habitually rewrite them by hand. The default merge commit message is Merge branch 'branch-name'. You may find it more helpful to have merge messages show up as Merge branch 'fix/CR15032/crash-when-unformatted-disk-inserted' instead of just Merge branch 'fix/CR15032'.

**Pull requests will be denied if branches don't follow this practice.**