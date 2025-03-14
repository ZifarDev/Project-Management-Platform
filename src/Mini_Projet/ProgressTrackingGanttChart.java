package Mini_Projet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.awt.Dimension;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ProgressTrackingGanttChart extends ApplicationFrame {
    private static final long serialVersionUID = 1L;

    public ProgressTrackingGanttChart(String title, List<AbstractTache> taches) {
        super(title);

     // Créer un jeu de données à partir de tâches
        TaskSeriesCollection dataset = createDataset(taches);

     // Générer un diagramme de Gantt
        JFreeChart chart = ChartFactory.createGanttChart(
            "Gantt Chart of Tasks", // Titre
            "Tâches",              // Domain axis
            "Timeline",            //Axe du domaine
            dataset,               // Jeu de données
            true,                  // Inclure la légende
            true,                  // Utilisez des infobulles
            false                  // URLs
        );

     // Intégrer le graphique dans le panneau
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(900, 600));
        setContentPane(chartPanel);
    }

    private TaskSeriesCollection createDataset(List<AbstractTache> taches) {
        TaskSeries series = new TaskSeries("Progress");

        for (AbstractTache tache : taches) {
        	// Convertir LocalDate en java.util.Date
            Date startDate = Date.from(tache.getDebut().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(tache.getFin().atStartOfDay(ZoneId.systemDefault()).toInstant());

         // Créer une tâche
            Task task = new Task(tache.getNom(), startDate, endDate);
            series.add(task);
        }

        TaskSeriesCollection dataset = new TaskSeriesCollection();
        dataset.add(series);
        return dataset;
    }
}
