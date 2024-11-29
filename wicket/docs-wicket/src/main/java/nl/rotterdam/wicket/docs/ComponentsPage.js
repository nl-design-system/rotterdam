document.addEventListener('DOMContentLoaded', function () {
  function updateTheme(newTheme) {
    const htmlElement = document.documentElement; // Get the <html> element
    const classes = htmlElement.classList; // Access the classList of <html>

    const classesToRemove = Array.from(classes).filter((className) => className.endsWith('-theme'));

    classesToRemove.forEach((className) => classes.remove(className));

    classes.add(newTheme);
  }

  const activeThemeDropdown = document.getElementById('activeTheme');

  activeThemeDropdown.addEventListener('change', function () {
    const newTheme = activeThemeDropdown.value;
    updateTheme(newTheme);
    console.log(`Set theme to: ${newTheme}`);
  });
});
