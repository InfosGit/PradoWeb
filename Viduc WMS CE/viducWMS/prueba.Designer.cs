namespace viducWMS
{
    partial class prueba
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.txtPrueba = new System.Windows.Forms.TextBox();
            this.textBtxtsuma = new System.Windows.Forms.TextBox();
            this.btnAceptar = new System.Windows.Forms.Button();
            this.dgDatosPrueba = new System.Windows.Forms.DataGrid();
            this.btnConfirmar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtPrueba
            // 
            this.txtPrueba.Location = new System.Drawing.Point(9, 7);
            this.txtPrueba.Name = "txtPrueba";
            this.txtPrueba.Size = new System.Drawing.Size(222, 21);
            this.txtPrueba.TabIndex = 0;
            this.txtPrueba.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtPrueba_KeyUp);
            // 
            // textBtxtsuma
            // 
            this.textBtxtsuma.Location = new System.Drawing.Point(10, 32);
            this.textBtxtsuma.Name = "textBtxtsuma";
            this.textBtxtsuma.Size = new System.Drawing.Size(221, 21);
            this.textBtxtsuma.TabIndex = 1;
            this.textBtxtsuma.KeyUp += new System.Windows.Forms.KeyEventHandler(this.textBtxtsuma_KeyUp);
            // 
            // btnAceptar
            // 
            this.btnAceptar.Location = new System.Drawing.Point(159, 59);
            this.btnAceptar.Name = "btnAceptar";
            this.btnAceptar.Size = new System.Drawing.Size(72, 24);
            this.btnAceptar.TabIndex = 2;
            this.btnAceptar.Text = "Aceptar";
            // 
            // dgDatosPrueba
            // 
            this.dgDatosPrueba.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgDatosPrueba.Location = new System.Drawing.Point(10, 89);
            this.dgDatosPrueba.Name = "dgDatosPrueba";
            this.dgDatosPrueba.Size = new System.Drawing.Size(223, 156);
            this.dgDatosPrueba.TabIndex = 3;
            // 
            // btnConfirmar
            // 
            this.btnConfirmar.Location = new System.Drawing.Point(161, 251);
            this.btnConfirmar.Name = "btnConfirmar";
            this.btnConfirmar.Size = new System.Drawing.Size(72, 25);
            this.btnConfirmar.TabIndex = 4;
            this.btnConfirmar.Text = "Aceptar";
            // 
            // prueba
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.btnConfirmar);
            this.Controls.Add(this.dgDatosPrueba);
            this.Controls.Add(this.btnAceptar);
            this.Controls.Add(this.textBtxtsuma);
            this.Controls.Add(this.txtPrueba);
            this.KeyPreview = true;
            this.Name = "prueba";
            this.Text = "prueba";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TextBox txtPrueba;
        private System.Windows.Forms.TextBox textBtxtsuma;
        private System.Windows.Forms.Button btnAceptar;
        private System.Windows.Forms.DataGrid dgDatosPrueba;
        private System.Windows.Forms.Button btnConfirmar;


    }
}