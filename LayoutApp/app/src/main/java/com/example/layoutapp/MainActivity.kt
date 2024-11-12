mport android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Criando o ConstraintLayout como layout principal
        val layout = ConstraintLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

// Criando o TextView para o título
        val titleTextView = TextView(this).apply {
            id = View.generateViewId()
            text = "Bem-vindo"
            textSize = 24f
        }

        // Criando o EditText para entrada de texto
        val inputEditText = EditText(this).apply {
            id = View.generateViewId()
            hint = "Digite algo"
        }

        // Criando o Button
        val actionButton = Button(this).apply {
            id = View.generateViewId()
            text = "Clique Aqui"
        }

        // Adicionando as views ao layout
        layout.addView(titleTextView)
        layout.addView(inputEditText)
        layout.addView(actionButton)

        // Definindo as restrições (constraints) para o layout
        val set = ConstraintSet()
        set.clone(layout)

        // Constraints para o título
        set.connect(titleTextView.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP, 32)
        set.connect(titleTextView.id, ConstraintSet.START, layout.id, ConstraintSet.START, 32)
        set.connect(titleTextView.id, ConstraintSet.END, layout.id, ConstraintSet.END, 32)

        // Constraints para o campo de entrada
        set.connect(inputEditText.id, ConstraintSet.TOP, titleTextView.id, ConstraintSet.BOTTOM, 32)
        set.connect(inputEditText.id, ConstraintSet.START, layout.id, ConstraintSet.START, 32)
        set.connect(inputEditText.id, ConstraintSet.END, layout.id, ConstraintSet.END, 32)

        // Constraints para o botão
        set.connect(actionButton.id, ConstraintSet.TOP, inputEditText.id, ConstraintSet.BOTTOM, 32)
        set.connect(actionButton.id, ConstraintSet.START, layout.id, ConstraintSet.START, 32)
        set.connect(actionButton.id, ConstraintSet.END, layout.id, ConstraintSet.END, 32)

        // Aplicando as constraints ao layout
        set.applyTo(layout)

        // Configurando o layout como a view principal da activity
        setContentView(layout)
    }
}







